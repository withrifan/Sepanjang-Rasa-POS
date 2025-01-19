package sepanjangrasapos;

import javax.swing.*;

public class Function {

    private static FormData formData;

    public static void saveData(JCheckBox[] checkBoxes, JSpinner[] spinners, JComboBox[] comboBoxes, JTextField[] textFields, JTextArea textArea) {
        int checkBoxCount = checkBoxes.length;
        int spinnerCount = spinners.length;
        int comboBoxCount = comboBoxes.length;
        int textFieldCount = textFields.length;

        formData = new FormData(checkBoxCount, spinnerCount, comboBoxCount, textFieldCount);

        boolean[] checkBoxData = new boolean[checkBoxCount];
        for (int i = 0; i < checkBoxCount; i++) {
            checkBoxData[i] = checkBoxes[i].isSelected();
        }
        formData.setCheckBoxData(checkBoxData);

        int[] spinnerData = new int[spinnerCount];
        for (int i = 0; i < spinnerCount; i++) {
            spinnerData[i] = (int) spinners[i].getValue();
        }
        formData.setSpinnerData(spinnerData);

        String[] comboBoxData = new String[comboBoxCount];
        for (int i = 0; i < comboBoxCount; i++) {
            comboBoxData[i] = (String) comboBoxes[i].getSelectedItem();
        }
        formData.setComboBoxData(comboBoxData);

        String[] textFieldData = new String[textFieldCount];
        for (int i = 0; i < textFieldCount; i++) {
            textFieldData[i] = textFields[i].getText();
        }
        formData.setTextFieldData(textFieldData);

        formData.setTextAreaData(textArea.getText());
    }

    public static void loadData(JCheckBox[] checkBoxes, JSpinner[] spinners, JComboBox[] comboBoxes, JTextField[] textFields, JTextArea textArea) {
        if (formData == null) {
            return;
        }

        boolean[] checkBoxData = formData.getCheckBoxData();
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i].setSelected(checkBoxData[i]);
        }

        int[] spinnerData = formData.getSpinnerData();
        for (int i = 0; i < spinners.length; i++) {
            spinners[i].setValue(spinnerData[i]);
        }

        String[] comboBoxData = formData.getComboBoxData();
        for (int i = 0; i < comboBoxes.length; i++) {
            comboBoxes[i].setSelectedItem(comboBoxData[i]);
        }

        String[] textFieldData = formData.getTextFieldData();
        for (int i = 0; i < textFields.length; i++) {
            textFields[i].setText(textFieldData[i]);
        }

        textArea.setText(formData.getTextAreaData());
    }
}
