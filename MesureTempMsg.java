/**
 * This class is automatically generated by mig. DO NOT EDIT THIS FILE.
 * This class implements a Java interface to the 'MesureTempMsg'
 * message type.
 */

public class MesureTempMsg extends net.tinyos.message.Message {

    /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 6;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 7;

    /** Create a new MesureTempMsg of size 6. */
    public MesureTempMsg() {
        super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new MesureTempMsg of the given data_length. */
    public MesureTempMsg(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new MesureTempMsg with the given data_length
     * and base offset.
     */
    public MesureTempMsg(int data_length, int base_offset) {
        super(data_length, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new MesureTempMsg using the given byte array
     * as backing store.
     */
    public MesureTempMsg(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new MesureTempMsg using the given byte array
     * as backing store, with the given base offset.
     */
    public MesureTempMsg(byte[] data, int base_offset) {
        super(data, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new MesureTempMsg using the given byte array
     * as backing store, with the given base offset and data length.
     */
    public MesureTempMsg(byte[] data, int base_offset, int data_length) {
        super(data, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new MesureTempMsg embedded in the given message
     * at the given base offset.
     */
    public MesureTempMsg(net.tinyos.message.Message msg, int base_offset) {
        super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new MesureTempMsg embedded in the given message
     * at the given base offset and length.
     */
    public MesureTempMsg(net.tinyos.message.Message msg, int base_offset, int data_length) {
        super(msg, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
    /* Return a String representation of this message. Includes the
     * message type name and the non-indexed field values.
     */
    public String toString() {
      String s = "Message <MesureTempMsg> \n";
      try {
        s += "  [data=0x"+Long.toHexString(get_data())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [dest_id=0x"+Long.toHexString(get_dest_id())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [src_id=0x"+Long.toHexString(get_src_id())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      return s;
    }

    // Message-type-specific access methods appear below.

    /////////////////////////////////////////////////////////
    // Accessor methods for field: data
    //   Field type: int, unsigned
    //   Offset (bits): 0
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'data' is signed (false).
     */
    public static boolean isSigned_data() {
        return false;
    }

    /**
     * Return whether the field 'data' is an array (false).
     */
    public static boolean isArray_data() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'data'
     */
    public static int offset_data() {
        return (0 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'data'
     */
    public static int offsetBits_data() {
        return 0;
    }

    /**
     * Return the value (as a int) of the field 'data'
     */
    public int get_data() {
        return (int)getUIntBEElement(offsetBits_data(), 16);
    }

    /**
     * Set the value of the field 'data'
     */
    public void set_data(int value) {
        setUIntBEElement(offsetBits_data(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'data'
     */
    public static int size_data() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'data'
     */
    public static int sizeBits_data() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: dest_id
    //   Field type: int, unsigned
    //   Offset (bits): 16
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'dest_id' is signed (false).
     */
    public static boolean isSigned_dest_id() {
        return false;
    }

    /**
     * Return whether the field 'dest_id' is an array (false).
     */
    public static boolean isArray_dest_id() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'dest_id'
     */
    public static int offset_dest_id() {
        return (16 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'dest_id'
     */
    public static int offsetBits_dest_id() {
        return 16;
    }

    /**
     * Return the value (as a int) of the field 'dest_id'
     */
    public int get_dest_id() {
        return (int)getUIntBEElement(offsetBits_dest_id(), 16);
    }

    /**
     * Set the value of the field 'dest_id'
     */
    public void set_dest_id(int value) {
        setUIntBEElement(offsetBits_dest_id(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'dest_id'
     */
    public static int size_dest_id() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'dest_id'
     */
    public static int sizeBits_dest_id() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: src_id
    //   Field type: int, unsigned
    //   Offset (bits): 32
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'src_id' is signed (false).
     */
    public static boolean isSigned_src_id() {
        return false;
    }

    /**
     * Return whether the field 'src_id' is an array (false).
     */
    public static boolean isArray_src_id() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'src_id'
     */
    public static int offset_src_id() {
        return (32 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'src_id'
     */
    public static int offsetBits_src_id() {
        return 32;
    }

    /**
     * Return the value (as a int) of the field 'src_id'
     */
    public int get_src_id() {
        return (int)getUIntBEElement(offsetBits_src_id(), 16);
    }

    /**
     * Set the value of the field 'src_id'
     */
    public void set_src_id(int value) {
        setUIntBEElement(offsetBits_src_id(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'src_id'
     */
    public static int size_src_id() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'src_id'
     */
    public static int sizeBits_src_id() {
        return 16;
    }

}
