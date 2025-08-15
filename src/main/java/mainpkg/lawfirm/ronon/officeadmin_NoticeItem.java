package mainpkg.lawfirm.ronon;

public class officeadmin_NoticeItem {

    private String title;
    private String message;

    public officeadmin_NoticeItem(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NoticeItem{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
