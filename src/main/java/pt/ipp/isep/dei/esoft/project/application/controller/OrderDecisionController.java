package pt.ipp.isep.dei.esoft.project.application.controller;
import pt.ipp.isep.dei.esoft.project.domain.EmailService;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.domain.OrderComparator;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;
public class OrderDecisionController {
    private static final OrderComparator orderComparator = new OrderComparator();

    /**
     * Order repository.
     */
    private final OrderRepository orderRepository;
    /**
     * Email service.
     */
    private final EmailService emailService;
    /**
     * Repositories.
     */
    public Repositories repositories;

    /**
     * Creates a new instance of OrderController with the given OrderRepository.
     *
     * @param orderRepository the OrderRepository to use
     */
    public OrderDecisionController(OrderRepository orderRepository, EmailService emailService) {
        this.orderRepository = orderRepository;
        this.emailService = emailService;
    }

    /**
     * Creates a new instance of OrderController with the default OrderRepository.
     */
    public OrderDecisionController() {
        repositories = Repositories.getInstance();
        this.orderRepository = repositories.getOrderRepository();
        this.emailService = new EmailService();
    }

    /**
     * Gets a list with the orders of a property.
     * @return list with the orders of a property
     */
    public List<Order> getOrderList() {
        List<Order> propertyOrders = orderRepository.getOrders();
        propertyOrders.sort(orderComparator);
        return propertyOrders;
    }

    /**
     * Makes a decision on an order based on the provided property code and order number.
     * @param propertyCode the property code
     * @param orderNumber the order number
     * @param decision the decision
     */
    public void makeDecision(String propertyCode, int orderNumber, boolean decision) {
        Order order = orderRepository.getOrderByPropertyCodeOrderNumber(propertyCode, orderNumber);
        order.makeDecision(decision);
        String clientName = order.getClientName();
        if (!decision) {
            emailService.sendRejectedOrderEmail(clientName, orderNumber);
            return;
        }
        emailService.sendAcceptedOrderEmail(clientName, orderNumber);
        for (Order propertyOrder : orderRepository.getUndecidedPropertyOrder(propertyCode)){
            propertyOrder.reject();
            propertyOrder.getPropertyAnnouncement();
            emailService.sendRejectedOrderEmail(clientName, orderNumber);
        }
    }
}