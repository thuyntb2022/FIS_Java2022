package core.ICore;

public interface CaseStatus {
    public void submitted();
    public void under_investigation();
    public void in_court();
    public void closed();
    public void dismissed();
    public void cold();

}
