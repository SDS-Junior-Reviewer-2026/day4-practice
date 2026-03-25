import java.util.List;

class Customer {
    private String address;
    private String type;

    public String getAddress() {
        return address;
    }

    public Object getType() {
        return type;
    }
}


class Order {

    private double price;
    private String id;
    private double quantity;
    private boolean earlyDelivery;

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public double getQuantity() {
        return quantity;
    }

    public boolean isEarlyDelivery() {
        return earlyDelivery;
    }
}


public class OrderService {

    public void processOrder(Customer customer, List<Order> orders) {
        double totalAmount = 0;
        String shippingLabels = "";
        int totalPoints = 0;

        for (Order order : orders) {
            double currentPrice = order.getPrice() * order.getQuantity();

            if (order.isEarlyDelivery()) {
                totalAmount += currentPrice + 5000;
                totalPoints += (int) (currentPrice * 0.05);
                shippingLabels += "[새벽]" + order.getId() + " " + customer.getAddress() + ", ";
            } else {
                totalAmount += currentPrice;
                totalPoints += (int) (currentPrice * 0.01);
                shippingLabels += "[일반]" + order.getId() + " " + customer.getAddress() + ", ";
            }
        }

        if (customer.getType().equals("VIP")) {
            totalAmount = totalAmount * 0.9;
            totalPoints += 500;
        }

        System.out.println("적립 포인트: " + totalPoints);
        System.out.println("배송지 목록: " + shippingLabels);
        System.out.println("최종 결제 금액: " + totalAmount);
    }
}


 
