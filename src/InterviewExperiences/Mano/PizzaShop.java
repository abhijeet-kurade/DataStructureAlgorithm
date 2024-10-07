package InterviewExperiences.Mano;

public class PizzaShop {
    
    class Pizza{
        public String name;
        public String price_S;
        public String price_M;
        public String price_L;

        public Pizza(String name, String price_S, String price_M, String price_L) {
            this.name = name;
            this.price_S = price_S;
            this.price_M = price_M;
            this.price_L = price_L;
        }
    }

    class OrderItem{
        public String name;
        public String size;
        public int quantity;

        public OrderItem(String name, String size, int quantity) {
            this.name = name;
            this.size = size;
            this.quantity = quantity;
        }
    }

    public int solution(Pizza[] menu, OrderItem[] order){

        return -1;
    }
}
