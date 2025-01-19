package sepanjangrasapos;

public class FormData {

    private boolean[] checkBoxData;
    private int[] spinnerData;
    private String[] comboBoxData;
    private String[] textFieldData;
    private String textAreaData;

    public FormData(int checkBoxCount, int spinnerCount, int comboBoxCount, int textFieldCount) {
        checkBoxData = new boolean[checkBoxCount];
        spinnerData = new int[spinnerCount];
        comboBoxData = new String[comboBoxCount];
        textFieldData = new String[textFieldCount];
    }

    // Setter and Getter methods for each data field
    public boolean[] getCheckBoxData() {
        return checkBoxData;
    }

    public void setCheckBoxData(boolean[] checkBoxData) {
        this.checkBoxData = checkBoxData;
    }

    public int[] getSpinnerData() {
        return spinnerData;
    }

    public void setSpinnerData(int[] spinnerData) {
        this.spinnerData = spinnerData;
    }

    public String[] getComboBoxData() {
        return comboBoxData;
    }

    public void setComboBoxData(String[] comboBoxData) {
        this.comboBoxData = comboBoxData;
    }

    public String[] getTextFieldData() {
        return textFieldData;
    }

    public void setTextFieldData(String[] textFieldData) {
        this.textFieldData = textFieldData;
    }

    public String getTextAreaData() {
        return textAreaData;
    }

    public void setTextAreaData(String textAreaData) {
        this.textAreaData = textAreaData;
    }
}
