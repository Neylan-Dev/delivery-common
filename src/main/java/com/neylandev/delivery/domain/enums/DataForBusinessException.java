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
    CLIENT_NOT_FOUND("Cliente não encontrado", FieldNames.CLIENT_ID, HttpStatus.NOT_FOUND),
    ORDER_NOT_FOUND("Pedido não encontrado", FieldNames.ORDER_ID, HttpStatus.NOT_FOUND),
    ORDER_CANNOT_BE_COMPLETED("Pedido não pode ser finalizado", FieldNames.ORDER_ID, HttpStatus.BAD_REQUEST),
    ORDER_CANNOT_BE_CANCELED("Pedido não pode ser cancelado", FieldNames.ORDER_ID, HttpStatus.BAD_REQUEST),
    CLIENT_ORDER_NOT_FOUND("Cliente do pedido não encontrado", FieldNames.CLIENT_ID, HttpStatus.BAD_REQUEST),
    EMAIL_EXISTS("Esse email já foi cadastrado", FieldNames.EMAIL, HttpStatus.BAD_REQUEST),
    TELEPHONE_EXISTS("Esse telefone já foi cadastrado", FieldNames.TELEPHONE, HttpStatus.BAD_REQUEST);


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
        private static final String ORDER_ID = "orderId=%s";
        private static final String EMAIL = "email=%s";
        private static final String TELEPHONE = "telephone=%s";
    }
}
