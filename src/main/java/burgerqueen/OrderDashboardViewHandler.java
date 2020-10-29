package burgerqueen;

import burgerqueen.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDashboardViewHandler {


    @Autowired
    private OrderDashboardRepository orderDashboardRepository;


    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaid_StartDelivery(@Payload Paid paid){
        System.out.println("##### Paid ddddddddd : " + paid.toJson() );
        if(paid.isMe()){


            System.out.println("##### Paid : " + paid.getOrderId() + ", " + orderDashboardRepository.count());

//            List<OrderDashboard> orderList = orderDashboardRepository.findAll();
//
//            for(OrderDashboard dashboard : orderList){
//                System.out.println("##### Test2 : " + paid.toJson());
//                dashboard.setState("Preparing");
//
//                orderDashboardRepository.save(dashboard);
//            }

            List<OrderDashboard> orderList = orderDashboardRepository.findByOrderId(paid.getOrderId());
            System.out.println("##### Test4 : " + orderList.size());
            for(OrderDashboard dashboard : orderList){
                System.out.println("##### Test2 : " + paid.toJson());
                dashboard.setState("Preparing");

                orderDashboardRepository.save(dashboard);
            }



        }

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrder_StartOrder(@Payload Ordered ordered){
        System.out.println("##### order 342 : " + ordered.toJson() );
        if(ordered.isMe()){

            System.out.println("##### Add Order : " + ordered.getId() );

            OrderDashboard orderDashboard = new OrderDashboard();
            orderDashboard.setOrderId(ordered.getId());
            orderDashboard.setBranchId(ordered.getBranchId());
            orderDashboard.setSauceId(ordered.getSauceId());
            orderDashboard.setPrice(ordered.getPrice());
            orderDashboard.setQty(ordered.getQty());
            orderDashboard.setState(ordered.getState());


            orderDashboardRepository.save(orderDashboard);


        }

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDelivered_StartDelivery(@Payload Delivered delivered){
        System.out.println("##### Delivered Sub1 : " + delivered.toJson() );
        if(delivered.isMe()){


            System.out.println("##### Delivered Sub2 : " + delivered.getOrderId() + ", " + orderDashboardRepository.count());

            List<OrderDashboard> orderList = orderDashboardRepository.findByOrderId(delivered.getOrderId());
            System.out.println("##### Delivered Sub3 : " + orderList.size());
            for(OrderDashboard dashboard : orderList){
                System.out.println("##### Delivered Sub4 : " + delivered.toJson());
                dashboard.setState(delivered.getState());

                orderDashboardRepository.save(dashboard);
            }


        }

    }


}