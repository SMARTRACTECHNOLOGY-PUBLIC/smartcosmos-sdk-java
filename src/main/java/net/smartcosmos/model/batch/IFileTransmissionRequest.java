package net.smartcosmos.model.batch;

public interface IFileTransmissionRequest
{
    /**
     * Size (in bytes) of the file being transmitted
     *
     * @return file size, in bytes
     */
    long getFileContentLength();

    /**
     * Size (in bytes) of the file being transmitted
     *
     * @param fileContentLength file size, in bytes
     */
    void setFileContentLength(long fileContentLength);

    /**
     * Base64 encoded, 128-bit MD5 digest of the file per RFC1864.
     *
     * @return Base64 encoded 128-bit MD5 digest of the file being transmitted
     */
    String getFileMd5Checksum();

    /**
     * Base64 encoded, 128-bit MD5 digest of the file per RFC1864.
     *
     * @param md5Checksum Base64 encoded 128-bit MD5 digest of the file being transmitted
     */
    void setFileMd5Checksum(String md5Checksum);

    /**
     * MIME type describing the format of the file being uploaded, e.g. {@code text/xml}.
     *
     * @return standard MIME type of the file being uploaded
     */
    String getFileContentType();

    /**
     * MIME type describing the format of the file being uploaded, e.g. {@code text/xml}.
     *
     * @param contentType standard MIME type of the file being uploaded
     */
    void setFileContentType(String contentType);

    /**
     * Identifies an internal, previously configured, routing URN within the server. Routing URNs identify a controller
     * class that has <i>a priori</i> knowledge of how to process and handle the data contained within the file being
     * uploaded.
     *
     * @return Previously configured routing URN
     */
    String getRoutingURN();

    /**
     * Identifies an internal, previously configured, routing URN within the server. Routing URNs identify a controller
     * class that has <i>a priori</i> knowledge of how to process and handle the data contained within the file being
     * uploaded.
     *
     * @param routingURN Previously configured routing URN
     */
    void setRoutingURN(String routingURN);
}
