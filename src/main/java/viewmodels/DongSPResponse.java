package viewmodels;

import java.util.UUID;

/**
 *
 * @author sonpt_ph19600
 */
public class DongSPResponse {
    private UUID id;
    private String ma;
    private String ten;
    
    public Object[] toDatarow(int index) {
        return new Object[]{index, ma, ten};
    }
}
