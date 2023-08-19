public class Reports {
    private int reportId;
    private String userName;
    private String description;

    public Reports(int reportId, String userName, String description) {
        this.reportId = reportId;
        this.userName = userName;
        this.description = description;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getReportID() {
        return reportId;
    }

    public void setReportID(int reportId) {
        this.reportId = reportId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static void main(String[] args) {
        Reports CALL2 = new Reports(
                1001,
                "Dr.Aminul",
                "Event: Black themed birthday party.\n" +
                        "Food:Black birthday cake, cupcakes-300, chips and coke.\n" +
                        "Date and Time: 18 September 2023, 5:00p.m.");
        CALL2.setUserName("Dr.Hasan");

        System.out.println("client Name:" + CALL2.getUserName());
        System.out.println("client ReportId:" + CALL2.getReportID());
        System.out.println("Description:\n" + CALL2.getDescription());

    }
}