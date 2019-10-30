package by.dziomin.trade.dto.receipt;

import by.dziomin.trade.dto.user.SessionUserDTO;

/**
 * DTO to create receipt
 *
 * @author - Pavel Dziomin
 */
public class ReceiptCreateDTO extends ReceiptDTO {
    private SessionUserDTO currentUser;

    public SessionUserDTO getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(final SessionUserDTO currentUser) {
        this.currentUser = currentUser;
    }
}
