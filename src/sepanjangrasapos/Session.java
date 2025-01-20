package sepanjangrasapos;

public class Session {
    private static String loggedInStaffID;
    private static String loggedInStaffName;
    private static String loggedInStaffRole;

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

    public static String getLoggedInStaffRole() {
        return loggedInStaffRole;
    }

    public static void setLoggedInStaffRole(String role) {
        loggedInStaffRole = role;
    }

    public static void clearSession() {
        loggedInStaffID = null;
        loggedInStaffName = null;
        loggedInStaffRole = null;
    }
}
