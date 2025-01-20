package sepanjangrasapos;

public class Session {

    private static String loggedInStaffID;
    private static String loggedInStaffName;
    private static String loggedInStaffJabatan; // Mengganti 'role' dengan 'jabatan'

    public static String getLoggedInStaffID() {
        return loggedInStaffID;
    }

    public static void setLoggedInStaffID(String idStaff) {
        loggedInStaffID = idStaff;
    }

    public static String getLoggedInStaffName() {
        return loggedInStaffName;
    }

    public static void setLoggedInStaffName(String name) {
        loggedInStaffName = name;
    }

    public static String getLoggedInStaffJabatan() {
        return loggedInStaffJabatan;
    }

    public static void setLoggedInStaffJabatan(String jabatan) {
        loggedInStaffJabatan = jabatan;
    }

    public static void clearSession() {
        loggedInStaffID = null;
        loggedInStaffName = null;
        loggedInStaffJabatan = null;
    }
}
