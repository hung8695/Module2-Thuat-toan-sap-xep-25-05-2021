public class Document {
   private String nxb;
   private int soBanPhatHanh;
   private int price;
   public Document(){}
    private String id;

    public Document( String nxb, int soBanPhatHanh, int price) {
        this.nxb = nxb;
        this.soBanPhatHanh = soBanPhatHanh;
        this.price=price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public int getSoBanPhatHanh() {
        return soBanPhatHanh;
    }

    public void setSoBanPhatHanh(int soBanPhatHanh) {
        this.soBanPhatHanh = soBanPhatHanh;
    }

    }

