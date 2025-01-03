/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sepanjangrasapos;

/**
 *
 * @author achmadrifan
 */
public class Session {

    private static String loggedInStaffID;

    public static String getLoggedInStaffID() {
        return loggedInStaffID;
    }

    public static void setLoggedInStaffID(String idStaff) {
        loggedInStaffID = idStaff;
    }
}
