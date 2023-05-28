/*package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
import java.util.List;

public class DisplayPropertiesOrdersController {

        private AnnouncementRepository announcementsRepository;
        private OrderRepository orderRepository;

        private AuthenticationRepository authenticationRepository;

        // public

        private List<Order> orders = new ArrayList<>();

        public DisplayPropertiesOrdersController (){
            getAnnouncementsRepository();
            getOrderRepository();
            getAuthenticationRepository();

        }

        public DisplayPropertiesOrdersController(AnnouncementRepository announcementsRepository, OrderRepository orderRepository, AuthenticationRepository authenticationRepository){
            this.announcementsRepository = announcementsRepository;
            this.orderRepository = orderRepository;
            this.authenticationRepository = authenticationRepository;
        }

        private AnnouncementRepository getAnnouncementsRepository(){

            Repositories repositories = Repositories.getInstance();
            announcementsRepository =  repositories.getAnnouncementRepository();

            return announcementsRepository;
        }
        private AuthenticationRepository getAuthenticationRepository() {
            if (authenticationRepository == null) {
                Repositories repositories = Repositories.getInstance();

                //Get the AuthenticationRepository
                authenticationRepository = repositories.getAuthenticationRepository();
            }
            return authenticationRepository;
        }
        public OrderRepository getOrderRepository(){
            Repositories repositories = Repositories.getInstance();
            orderRepository = repositories.getOrderRepository();

            return orderRepository;
        }

        public List<Announcement> getAnnouncement(){
            AnnouncementRepository announcementsRepository = new AnnouncementRepository();

            return announcementsRepository.getAnnouncementsRepository();

        }

        public  List<Order> getOrders(){
            OrderRepository orderRepository = new OrderRepository();

            return orderRepository.getOrderRepositoryList();
        }

        private User getEmployeeFromSession() throws FileNotFoundException {
            Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
            return new User(email.getEmail(),"1",1,1, User.Roles.ROLE_AGENT,1);
        }


        public List<Order> getOrdersByAnnouncement(Announcement announcement){
            return announcement.getOrders();

        }
        public Announcement getAnnouncementByOrder(Order order){
            return announcementsRepository.getAnnouncementByOrder(order);
        }

   /*public boolean setOrder(Order order, Status status) throws FileNotFoundException {
        User client = order.getClient();
        User agent = getEmployeeFromSession();
        Announcement announcement = getAnnouncementByOrder(order);
        return agent.setOrder(announcement, order, client, status);
    }

        public Order getOrderById(int id){return orderRepository.getOrderById(id);}
    }
} */
