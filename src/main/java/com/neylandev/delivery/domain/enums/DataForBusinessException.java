package com.neylandev.delivery.domain.enums;

import com.neylandev.delivery.infrastructure.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum DataForBusinessException {

    INVALID_INPUT("Entrada de dados inválida", null, HttpStatus.BAD_REQUEST),
    ILLEGAL_ARGUMENT_EXCEPTION("Argumento informado não é válido.", null, HttpStatus.BAD_REQUEST),
    MUST_FILL_AT_LEAST_ONE_FIELD("É necessário preencher pelo menos um campo", null, HttpStatus.BAD_REQUEST),
    CLIENT_NOT_FOUND("Cliente não encontrado", FieldNames.CLIENT_ID, HttpStatus.NOT_FOUND),
    ORDER_NOT_FOUND("Pedido não encontrado", FieldNames.ORDER_ID, HttpStatus.NOT_FOUND),
    PRODUCT_NOT_FOUND("Produto não encontrado", FieldNames.PRODUCT_ID, HttpStatus.NOT_FOUND),
    ORDER_CANNOT_BE_DISPATCHED("Pedido não pode ser despachado", FieldNames.ORDER_ID, HttpStatus.BAD_REQUEST),
    ORDER_CANNOT_BE_DELIVERED("Pedido não pode ser entregue", FieldNames.ORDER_ID, HttpStatus.BAD_REQUEST),
    PAYMENT_NOT_FOUND("Pagamento não encontrado", FieldNames.PAYMENT_ID, HttpStatus.NOT_FOUND),
    PAYMENT_INCORRECT("O pagamento informado não é igual ao do produto", null, HttpStatus.BAD_REQUEST),
    PAYMENT_CANNOT_BE_SAVED("O pagamento não pode ser salvo porque o tipo não corresponde aos dados informados", null, HttpStatus.BAD_REQUEST),
    PRODUCT_NAME_IS_NULL("O nome do produto não pode ser nulo", null, HttpStatus.BAD_REQUEST),
    PRODUCT_PRICE_IS_NULL("O preço do produto não pode ser nulo", null, HttpStatus.BAD_REQUEST),
    PRODUCT_CATEGORY_IS_NULL("A categoria do produto não pode ser nula", null, HttpStatus.BAD_REQUEST),
    PRODUCT_DESCRIPTION_IS_NULL("A descrição do produto não pode ser nula", null, HttpStatus.BAD_REQUEST),
    PRODUCT_IMAGE_URL_IS_NULL("A url do produto não pode ser nula", null, HttpStatus.BAD_REQUEST),
    PRODUCT_EXISTS("Esse produto já foi cadastrado", FieldNames.PRODUCT_ID, HttpStatus.BAD_REQUEST),
    PRODUCT_NOT_FOUND_IN_STOCK("Produto não encontrado no estoque", FieldNames.PRODUCT_NAME, HttpStatus.NOT_FOUND),
    QUANTITY_PRODUCT_GREATER_THAN_QUANTITY_STOCK("A quantidade do produto é maior do que a presente em estoque", FieldNames.PRODUCT_ID, HttpStatus.BAD_REQUEST),
    ORDER_CANNOT_BE_PAID("Pedido não pode ser pago", FieldNames.ORDER_ID, HttpStatus.BAD_REQUEST),
    ORDER_CANNOT_BE_CANCELED("Pedido não pode ser cancelado", FieldNames.ORDER_ID, HttpStatus.BAD_REQUEST),
    ORDER_CANNOT_CHANGE_STATUS("Pedido não pode ter seu status mudado", FieldNames.ORDER_ID, HttpStatus.BAD_REQUEST),
    CLIENT_ORDER_NOT_FOUND("Cliente do pedido não encontrado", FieldNames.CLIENT_ID, HttpStatus.BAD_REQUEST),
    EMAIL_EXISTS("Esse email já foi cadastrado", FieldNames.EMAIL, HttpStatus.BAD_REQUEST),
    TELEPHONE_EXISTS("Esse telefone já foi cadastrado", FieldNames.TELEPHONE, HttpStatus.BAD_REQUEST),
    EMAIL_CANNOT_BE_SEND("O email não pode ser enviado nesse momento", null, HttpStatus.BAD_REQUEST),
    REFUND_CANNOT_BE_DONE("O reembolso de PIX e BOLETO dependem de uma conta cadastrada, cadastre uma conta e solicite o reembolso", null, HttpStatus.BAD_REQUEST);


    private String message;
    private String description;
    private HttpStatus statusCode;

    public BusinessException asBusinessException() {
        return BusinessException.builder().httpStatusCode(this.getStatusCode()).message(this.getMessage()).build();
    }

    public BusinessException asBusinessExceptionWithDescriptionFormatted(String formatDescription) {
        return BusinessException.builder().httpStatusCode(this.getStatusCode()).message(this.getMessage()).description(formatDescription(formatDescription)).build();
    }

    public BusinessException asBusinessExceptionWithDescription(String description) {
        return BusinessException.builder().httpStatusCode(this.getStatusCode()).message(this.getMessage()).description(description).build();
    }

    public String formatDescription(String... value) {
        return String.format(this.getDescription(), value);
    }

    private static class FieldNames {
        public static final String CLIENT_ID = "clientId=%s";
        public static final String PRODUCT_ID = "productId=%s";
        public static final String PRODUCT_NAME = "productName=%s";
        private static final String ORDER_ID = "orderId=%s";
        private static final String PAYMENT_ID = "paymentId=%s";
        private static final String EMAIL = "email=%s";
        private static final String TELEPHONE = "telephone=%s";
    }
}
