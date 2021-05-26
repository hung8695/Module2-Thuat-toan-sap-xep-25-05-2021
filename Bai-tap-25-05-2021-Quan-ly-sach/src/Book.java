import java.util.ArrayList;
import java.util.List;

public class Book extends Document {
    static final String MA_SACH ="BOOK";
    static int number1=1;
    private String name;
    private String tenTacGia;
    private String id=MA_SACH+number1;

    public Book(){
      number1++;
    }


    public Book( String name,String nxb, int soBanPhatHanh,int price ,String tenTacGia) {
        super( nxb, soBanPhatHanh,price);
        this.tenTacGia=tenTacGia;
        this.name=name;
        number1++;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Book{" +
                " Tên: " + name +
                ", NXB: " + getNxb() +
                ", Số bản phát hành: " + getSoBanPhatHanh() +
                ", Tên tác giả: " + tenTacGia +

                ", Id: " + getId() +
                ", Giá: " + getPrice() +'$'+
                " }";
    }

    @Override
    public String getId() {
        return id;
    }
}
