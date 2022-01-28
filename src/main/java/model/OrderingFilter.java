package model;

public class OrderingFilter {

    private int lowerLimit;
    private int UpperLimit;
    private OrderType orderType;

    public OrderingFilter(int lowerLimit, int upperLimit, OrderType orderType) {
        this.lowerLimit = lowerLimit;
        this.UpperLimit = upperLimit;
        this.orderType = orderType;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public int getUpperLimit() {
        return UpperLimit;
    }

    public OrderType getOrderType() {
        return orderType;
    }
}
