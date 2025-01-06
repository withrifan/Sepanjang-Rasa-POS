package sepanjangrasapos;

public class Session {

    private static String loggedInStaffID;

    public static String getLoggedInStaffID() {
        return loggedInStaffID;
    }

    public static void setLoggedInStaffID(String idStaff) {
        loggedInStaffID = idStaff;
    }
}
