package com.poctestbank.controller.dto.request;

import java.math.BigDecimal;

public record OrderRequest(String destination,
                           String origin,
                           BigDecimal amount) {
}
