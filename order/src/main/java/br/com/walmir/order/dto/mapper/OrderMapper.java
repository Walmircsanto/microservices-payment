package br.com.walmir.order.dto.mapper;

import br.com.walmir.order.dto.RequestOrderDTO;
import br.com.walmir.order.dto.ResponseOrderDTO;
import br.com.walmir.order.model.Order;
import br.com.walmir.order.utils.GeneratedIdRequest;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class OrderMapper {

    public RequestOrderDTO toOrderDTO(Order order) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        RequestOrderDTO requestOrderDTO = new RequestOrderDTO();
        requestOrderDTO.setOrderStatus(order.getStatus());
        requestOrderDTO.setNumberCard(order.getUser().getNumberCard());
        requestOrderDTO.setIdProduct(order.getProductId());
        requestOrderDTO.setIdRequestOrder(new GeneratedIdRequest().generatedHashId(requestOrderDTO));
        return requestOrderDTO;


    }

    public ResponseOrderDTO toResponseDTO(Order order) {
        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO(order.getIdOrder(),order.getUser().getNumberCard(),
                order.getProductId(),order.getStatus());

        return responseOrderDTO;
    }

//    public Order toOrder(RequestOrderDTO requestOrderDTO){
//
//    }
}
