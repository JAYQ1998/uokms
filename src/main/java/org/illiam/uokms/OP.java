package main.java.org.illiam.uokms;


/**
 * Oblivious protocol constants and common fields.
 * */
public class OP {
    /**
     * Mandatory fields for each message exchange.
     * */
    public static final String NAME = "name";
    public static final String METHOD = "method";

    /**
     * GetDomainParameters section.
     * Contains the method name and domain values: P,Q,G from the DSA.
     * DSA generation is used because it provides domain parameters asymmetric encryption.
     * */
    public static final String GetDomainParameters = "GetDomainParameters";
    public static final String P = "P";
    public static final String Q = "Q";
    public static final String G = "G";

    /**
     * EnrollClient section.
     * */
    public static final String EnrollClient = "EnrollClient";

    /**
     * GetPublicKey section. Public key Y is generated by the DSA KeyPair generator.
     * */
    public static final String GetPublicKey = "GetPublicKey";
    public static final String Y = "Y";
    public static final String PublicKeyRevision = "PublicKeyRevision";

    /**
     * RetrieveObjectKey section. U is a client-side argument, V is returned by the KMS.
     * */
    public static final String RetrieveObjectKey = "RetrieveObjectKey";
    public static final String U = "U";
    public static final String V = "V";

    /**
     * ReadWriteStorageEntry section. ObjId, W, and EncMsg are passed both ways.
     * */
    public static final String ReadStorageEntry = "ReadStorageEntry";
    public static final String WriteStorageEntry = "WriteStorageEntry";
    public static final String ObjId = "ObjId";
    public static final String W = "W";
    public static final String EncObj = "EncObj";

    /**
     * UpdateKey section.
     * */
    public static final String UpdateKey = "UpdateKey";
    public static final String Delta = "Delta";

    /**
     * Error handling section.
     * */

    public static final String Error = "error";
    public static final String Success = "success";

    public static final String Res = "res";
    public static final String Comment = "comment";
    public static final String InvalidRequestMethod = "Invalid request method";

    public static final String STATUS = "status";
    public static final String StatusOk = "200";
    public static final String StatusNotFound = "404";
    public static final String StatusInternalError = "500";
}
