class FoodItem{
    protected String itemId;
    protected String itemName;
    protected double unitPrice;
    protected int quantity;
    protected double charges;
    protected double subTotal;
    protected double gst;
    protected double discount;
    protected double totalBill; 
    FoodItem(String itemId,String itemName,double unitPrice,int quantity){
        this.itemId=itemId;
        this.itemName=itemName;
        this.unitPrice=unitPrice;
        this.quantity=quantity;
    }
    public double calculateBill(){
        double grossAmount=unitPrice*quantity;
        subTotal=grossAmount+charges;
        if(subTotal>1000){
            discount=subTotal*0.10;
        }
        double taxableAmount=subTotal-discount;
        gst=taxableAmount*0.05;
        totalBill=taxableAmount+gst;
        return totalBill;
    }
    public void displayDetails(){
        System.out.println("Food Item Record");
        System.out.println("ID "+itemId);
        System.out.println("Name "+itemName);
        System.out.println("Unit Price "+unitPrice);
        System.out.println("Quantity "+quantity);
        System.out.println("Charges "+charges);
        System.out.println("Subtotal "+subTotal);
        System.out.printf("GST %.2f \n",gst);
        System.out.println("Discount "+discount);
        System.out.println("Total Bill "+totalBill);
        System.out.println();
    }
}
class DineIn extends FoodItem{
    private double serviceCharge;
    DineIn(String itemId,String itemName,double unitPrice,int quantity,double serviceCharge){
        super(itemId,itemName,unitPrice,quantity);
        this.serviceCharge=serviceCharge;
    }
    @Override
    public double calculateBill(){
        charges=serviceCharge;
        return super.calculateBill();
    }
    @Override
    public void displayDetails(){
        System.out.println("Food Item Record");
        System.out.println("ID "+itemId);
        System.out.println("Name "+itemName);
        System.out.println("Unit Price "+unitPrice);
        System.out.println("Quantity "+quantity);
        System.out.println("Service Charge "+serviceCharge);
        System.out.println("Subtotal "+subTotal);
        System.out.printf("GST %.2f \n",gst);
        System.out.println("Discount "+discount);
        System.out.println("Total Bill "+totalBill);
        System.out.println();
    }
}
class Takeaway extends FoodItem{
    private double packingCharge;
    Takeaway(String itemId,String itemName,double unitPrice,int quantity,double packingCharge){
        super(itemId,itemName,unitPrice,quantity);
        this.packingCharge=packingCharge;
    }
    @Override
    public double calculateBill(){
        charges=packingCharge;
        return super.calculateBill();
    }
    @Override
    public void displayDetails(){
        System.out.println("Food Item Record");
        System.out.println("ID "+itemId);
        System.out.println("Name "+itemName);
        System.out.println("Unit Price "+unitPrice);
        System.out.println("Quantity "+quantity);
        System.out.println("Packing Charge "+packingCharge);
        System.out.println("Subtotal "+subTotal);
        System.out.printf("GST %.2f \n",gst);
        System.out.println("Discount "+discount);
        System.out.println("Total Bill "+totalBill);
        System.out.println();
    }
}
class Delivery extends FoodItem{
    private double deliveryFee;
    Delivery(String itemId,String itemName,double unitPrice,int quantity,double deliveryFee){
        super(itemId,itemName,unitPrice,quantity);
        this.deliveryFee=deliveryFee;
    }
    @Override
    public double calculateBill(){
        charges=deliveryFee;
        return super.calculateBill();
    }
    @Override
    public void displayDetails(){
        System.out.println("Food Item Record");
        System.out.println("ID "+itemId);
        System.out.println("Name "+itemName);
        System.out.println("Unit Price "+unitPrice);
        System.out.println("Quantity "+quantity);
        System.out.println("Delivery Fee "+deliveryFee);
        System.out.println("Subtotal "+subTotal);
        System.out.printf("GST %.2f \n",gst);
        System.out.println("Discount "+discount);
        System.out.println("Total Bill "+totalBill);
        System.out.println();
    }
}
public class RestaurantBilling{
    public static void main(String[] args){
        FoodItem[] orders = new FoodItem[3];
        orders[0] = new DineIn("F101", "Paneer Butter Masala", 250.0, 4, 50.0);
        orders[1] = new Takeaway("F102", "Veg Biryani", 180.0, 2, 20.0);
        orders[2] = new Delivery("F103", "Chicken Pizza", 300.0, 4, 40.0);
        for (FoodItem order : orders) {
            order.calculateBill();
            order.displayDetails();
        }
    }
}