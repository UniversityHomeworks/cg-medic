package top.jonakls.cgmedic.test;

import org.junit.Assert;
import org.junit.Test;
import top.jonakls.cgmedic.api.entity.account.UserAccountEntity;
import top.jonakls.cgmedic.api.entity.user.UserEntity;
import top.jonakls.cgmedic.api.entity.user.history.HistoryEntity;
import top.jonakls.cgmedic.api.storage.ObjectStorage;
import top.jonakls.cgmedic.core.service.entity.account.SimpleAccountService;
import top.jonakls.cgmedic.core.storage.ObjectJsonStorage;

import java.util.List;
import java.util.UUID;

public class UserFileTest {

    @Test
    public void fileTest() {

        ObjectStorage<UserAccountEntity> objectStorage = new ObjectJsonStorage<>(
                "E:\\Testing\\CGMedic"
        );

        SimpleAccountService simpleAccountService = new SimpleAccountService(objectStorage);
        UserAccountEntity userAcc1 = UserAccountEntity.createUser(
                "AAAA", "AAAA",
                "AAAA", "AAA",
                "AAAA", "AAAA"
        );
        UserAccountEntity userAcc2 = UserAccountEntity.createUser(
                "BBBB", "BBBB",
                "BBBB", "BBB",
                "BBBB", "BBBB"
        );

        final UUID hId1 = UUID.randomUUID();
        final UUID hId2 = UUID.randomUUID();

        HistoryEntity historyEntity = HistoryEntity.createHistory(
                hId1.toString(), null,
                "AAAA", "AAA",
                "AAAA", "AAAA",
                List.of("DIAG 1"), List.of("Azitromicina")
        );

        HistoryEntity historyEntity2 = HistoryEntity.createHistory(
                hId2.toString(), null,
                "BBBB", "BBB",
                "BBBB", "BBBB",
                List.of("DIAG 2"), List.of("Azitromicina")
        );

        UserEntity testUser = (UserEntity) userAcc1.userEntity();
        testUser.addHistory(historyEntity);
        testUser.addHistory(historyEntity2);


        final String id1 = userAcc1.uuid();
        final String id2 = userAcc2.uuid();

        simpleAccountService.add(userAcc1);
        simpleAccountService.add(userAcc2);
        userAcc1 = null;
        userAcc2 = null;

        simpleAccountService.saveAll();
        simpleAccountService.deleteOfCache(id1);
        simpleAccountService.deleteOfCache(id2);

        simpleAccountService.load(id1);
        simpleAccountService.load(id2);

        userAcc1 = simpleAccountService.get(id1);
        userAcc2 = simpleAccountService.get(id2);


        Assert.assertNotNull(userAcc1);
        Assert.assertNotNull(userAcc2);

        Assert.assertEquals(userAcc1.uuid(), id1);
        Assert.assertEquals(userAcc2.uuid(), id2);

        Assert.assertEquals(userAcc1.userEntity().uuid(), id1);
        Assert.assertEquals(userAcc2.userEntity().uuid(), id2);

        UserEntity user1 = (UserEntity) userAcc1.userEntity();

        Assert.assertTrue(user1.hasHistory(hId1.toString()));
        Assert.assertTrue(user1.hasHistory(hId2.toString()));

        HistoryEntity history1 = user1.getHistory(hId1.toString());
        HistoryEntity history2 = user1.getHistory(hId2.toString());

        Assert.assertEquals(history1.uuid(), hId1.toString());
        Assert.assertEquals(history2.uuid(), hId2.toString());
    }

}
