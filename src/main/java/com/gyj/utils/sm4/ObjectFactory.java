
package com.gyj.utils.sm4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gyj.utils.sm4 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DecryptInfoResponse_QNAME = new QName("http://ws.dhcc_sm4.dhcc.com.cn/", "decryptInfoResponse");
    private final static QName _EncryptInfoResponse_QNAME = new QName("http://ws.dhcc_sm4.dhcc.com.cn/", "encryptInfoResponse");
    private final static QName _DecryptInfo_QNAME = new QName("http://ws.dhcc_sm4.dhcc.com.cn/", "decryptInfo");
    private final static QName _EncryptInfo_QNAME = new QName("http://ws.dhcc_sm4.dhcc.com.cn/", "encryptInfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gyj.utils.sm4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DecryptInfoResponse }
     * 
     */
    public DecryptInfoResponse createDecryptInfoResponse() {
        return new DecryptInfoResponse();
    }

    /**
     * Create an instance of {@link EncryptInfoResponse }
     * 
     */
    public EncryptInfoResponse createEncryptInfoResponse() {
        return new EncryptInfoResponse();
    }

    /**
     * Create an instance of {@link DecryptInfo }
     * 
     */
    public DecryptInfo createDecryptInfo() {
        return new DecryptInfo();
    }

    /**
     * Create an instance of {@link EncryptInfo }
     * 
     */
    public EncryptInfo createEncryptInfo() {
        return new EncryptInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DecryptInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.dhcc_sm4.dhcc.com.cn/", name = "decryptInfoResponse")
    public JAXBElement<DecryptInfoResponse> createDecryptInfoResponse(DecryptInfoResponse value) {
        return new JAXBElement<DecryptInfoResponse>(_DecryptInfoResponse_QNAME, DecryptInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EncryptInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.dhcc_sm4.dhcc.com.cn/", name = "encryptInfoResponse")
    public JAXBElement<EncryptInfoResponse> createEncryptInfoResponse(EncryptInfoResponse value) {
        return new JAXBElement<EncryptInfoResponse>(_EncryptInfoResponse_QNAME, EncryptInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DecryptInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.dhcc_sm4.dhcc.com.cn/", name = "decryptInfo")
    public JAXBElement<DecryptInfo> createDecryptInfo(DecryptInfo value) {
        return new JAXBElement<DecryptInfo>(_DecryptInfo_QNAME, DecryptInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EncryptInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.dhcc_sm4.dhcc.com.cn/", name = "encryptInfo")
    public JAXBElement<EncryptInfo> createEncryptInfo(EncryptInfo value) {
        return new JAXBElement<EncryptInfo>(_EncryptInfo_QNAME, EncryptInfo.class, null, value);
    }

}
