package burgerqueen;

public class Ordered extends AbstractEvent {

    private Long id;
    private Long branchId;
    private String sauceId;
    private Integer qty;
    private Integer price;
    private String state;

    public Ordered(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getSauceId() {
        return sauceId;
    }

    public void setSauceId(String sauceId) {
        this.sauceId = sauceId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
