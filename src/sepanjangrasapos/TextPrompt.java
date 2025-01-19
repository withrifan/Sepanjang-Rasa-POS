package sepanjangrasapos;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

public class TextPrompt extends JLabel implements FocusListener, DocumentListener {

    private static final long serialVersionUID = 1L;

    private JTextComponent component;
    private Document document;

    public enum Show {
        ALWAYS, FOCUS_GAINED, FOCUS_LOST;
    }

    private Show show;
    private boolean showPromptOnce;
    private int focusLost;

    public TextPrompt(String text, JTextComponent component) {
        this(text, component, Show.ALWAYS);
    }

    public TextPrompt(String text, JTextComponent component, Show show) {
        this.component = component;
        setShow(show);
        document = component.getDocument();

        setText(text);
        setFont(component.getFont());
        setForeground(Color.GRAY);
        setHorizontalAlignment(JLabel.LEADING);

        component.addFocusListener(this);
        document.addDocumentListener(this);

        component.setLayout(new BorderLayout());
        component.add(this);
        checkForPrompt();
    }

    public void changeAlpha(float alpha) {
        changeAlpha((int) (alpha * 255));
    }

    public void changeAlpha(int alpha) {
        alpha = alpha > 255 ? 255 : alpha < 0 ? 0 : alpha;
        Color foreground = getForeground();
        Color withAlpha = new Color(foreground.getRed(), foreground.getGreen(), foreground.getBlue(), alpha);
        super.setForeground(withAlpha);
    }

    public void changeStyle(int style) {
        setFont(getFont().deriveFont(style));
    }

    public void setPromptFont(Font font) {
        setFont(font);
    }

    public void setPromptColor(Color color) {
        setForeground(color);
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public boolean getShowPromptOnce() {
        return showPromptOnce;
    }

    public void setShowPromptOnce(boolean showPromptOnce) {
        this.showPromptOnce = showPromptOnce;
    }

    private void checkForPrompt() {
        if (document.getLength() > 0) {
            setVisible(false);
            return;
        }

        if (showPromptOnce && focusLost > 0) {
            setVisible(false);
            return;
        }

        if (component.hasFocus()) {
            if (show == Show.ALWAYS || show == Show.FOCUS_GAINED) {
                setVisible(true);
            } else {
                setVisible(false);
            }
        } else {
            if (show == Show.ALWAYS || show == Show.FOCUS_LOST) {
                setVisible(true);
            } else {
                setVisible(false);
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        checkForPrompt();
    }

    @Override
    public void focusLost(FocusEvent e) {
        focusLost++;
        checkForPrompt();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        checkForPrompt();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        checkForPrompt();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
}
