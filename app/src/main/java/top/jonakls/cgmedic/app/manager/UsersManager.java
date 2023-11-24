package top.jonakls.cgmedic.app.manager;

import top.jonakls.cgmedic.api.entity.account.UserAccountEntity;
import top.jonakls.cgmedic.core.service.entity.account.SimpleAccountService;
import top.jonakls.cgmedic.core.storage.ObjectJsonStorage;

public class UsersManager {

    private SimpleAccountService accountService;
    private ObjectJsonStorage<UserAccountEntity> storage;

    public UsersManager(String path) {
        this.storage = new ObjectJsonStorage<>(path);
        this.accountService = new SimpleAccountService(storage);



    }

}
