package vn.vcc.adopt.type;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum chứa các bidtype như CPC hay CPM
 *
 * @author ngocvm
 *
 */
public enum BidType {
    /**
     * <li>CPM la bid theo CPM <br>
     * <li>CPC la bid theo click<br>
     * <li>CPD la banner chay theo thoi gian, hien tai banner chay theo cpd<br>
     * khong tinh gia bid, va chay doc quyen
     */
    CPM(2), CPC(1), CPD(0);
    private static Map<Integer, BidType> map = new HashMap<>();
    static {
        for (BidType bidType : BidType.values()) {
            map.put(bidType.bidTypeId, bidType);
        }
    }
    private int bidTypeId;

    private BidType(int bidTypeId) {
        this.bidTypeId = bidTypeId;
    }

    public int getValue() {
        return bidTypeId;
    }

    /**
     * Tra lai BidType tuong ung voi Id
     *
     * @param bidTypeId
     * @return
     */
    public static BidType valueOf(int bidTypeId) {
        return map.get(bidTypeId);
    }
}