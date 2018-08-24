package vn.vcc.adopt.type;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum định nghĩa tất cả các loại banner bid theo keyword có trong hệ thống
 * đang được chạy trên nền web:
 * <li>USER = 1
 * <li>CONTENT = 0
 *
 * @author chienpq
 *
 */
public enum KeywordType {
    NONE(0), USER(1), CONTENT(2);
    private static Map<Integer, KeywordType> map = new HashMap<>();
    static {
        for (KeywordType bannerType : KeywordType.values()) {
            map.put(bannerType.typeId, bannerType);
        }
    }

    private int typeId;

    private KeywordType(int typeId) {
        this.typeId = typeId;
    }

    public int getValue() {
        return typeId;
    }

    /**
     * Tra lai banner type tương ứng với banner type Id
     *
     * @param bannerTypeId
     * @return
     */
    public static KeywordType valueOf(int bannerTypeId) {
        return map.get(bannerTypeId);
    }
}