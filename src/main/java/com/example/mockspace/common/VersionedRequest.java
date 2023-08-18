package com.example.mockspace.common;

/**
 * @author lanjzh
 */
public class VersionedRequest implements Request {

    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
