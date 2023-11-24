package top.jonakls.cgmedic.app.manager;

import top.jonakls.cgmedic.api.entity.account.UserAccountEntity;
import top.jonakls.cgmedic.core.service.entity.account.SimpleAccountService;
import top.jonakls.cgmedic.core.storage.ObjectJsonStorage;

public class UsersManager {

    private final SimpleAccountService accountService;

    public UsersManager(String path) {
        this.accountService = new SimpleAccountService(new ObjectJsonStorage<>(path));
    }

    public SimpleAccountService accountService() {
        return accountService;
    }
}
