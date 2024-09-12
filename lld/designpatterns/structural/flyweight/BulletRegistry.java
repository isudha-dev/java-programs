package lld.designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class BulletRegistry {
    Map<BulletType, Bullet> register = new HashMap<>();

    public void addBullet(Bullet bullet){
        register.put(bullet.getType(), bullet);
    }

    public Bullet getBullet(BulletType type) {
        return register.get(type);
    }

}
