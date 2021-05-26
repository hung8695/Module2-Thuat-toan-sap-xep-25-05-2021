public class Newspaper extends Document{
    static final String MA_TAP_CHI = "NEWSPAPER";
    static int number2=1;
    private String id=MA_TAP_CHI+number2;
    private String date;
    public Newspaper(){
        number2++;
    }
    public Newspaper(String nxb, int soBanPhatHanh,int price, String date) {
        super(nxb, soBanPhatHanh,price);
        this.date = date;
        number2++;
    }

    public String getId() {
        return id;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return " Newspaper{" +
                " NXB: " + getNxb() +
                ", Số bản phát hành: " + getSoBanPhatHanh() +
                ", Ngày phát hành: " + date +
                ", Id: " + id +
                ", Giá: " + getPrice() +'$'+
                " }";
    }


}
