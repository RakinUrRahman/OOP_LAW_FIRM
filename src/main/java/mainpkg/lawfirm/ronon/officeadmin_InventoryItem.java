package mainpkg.lawfirm.ronon;

import java.time.LocalDate;

public class officeadmin_InventoryItem {

    private String itemName;
    private String vendor;
    private int quantity;
    private LocalDate date;

    public officeadmin_InventoryItem(String itemName, String vendor, int quantity, LocalDate date) {
        this.itemName = itemName;
        this.vendor = vendor;
        this.quantity = quantity;
        this.date = date;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "InventoryItem{" +
                "itemName='" + itemName + '\'' +
                ", vendor='" + vendor + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}
