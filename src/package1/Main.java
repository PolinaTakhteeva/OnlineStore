package package1;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ahtyamov Danil");
        DataBase data = new DataBase();
        //data.deleteProduct(9);
        List list1 = data.priceSelection(100,400);
        List list2 = data.yearSelection(1864,1900);
        List list3 =data.getAllProducts();
        System.out.println(list2);
    }
}
