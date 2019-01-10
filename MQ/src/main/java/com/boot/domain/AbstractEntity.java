package com.boot.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.sf.json.JSONObject;


/**
 * 类名: com.lanbin.dinosaurs.productservice.base.model.AbstractEntity
 * <p>
 * 描述: TODO
 * </p>
 * 日期: 2016�?8�?24�? 下午9:52:05
 *
 * @author 蓝斌
 * @since JDK1.8
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 7086152182345549297L;
   
    private String id;

    private long version;


    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = "".equals(id)?null:id;
	}

	@Version
	@JsonIgnore
    public long getVersion() { return this.version; }

    public void setVersion(long version) { this.version = version; }


   /* @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + (int) (this.version ^ (this.version >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof AbstractEntity)) return false;
        AbstractEntity other = (AbstractEntity) obj;
        if (this.id == null)
            if (other.id != null) return false;
        else if (!this.id.equals(other.id))
            return false;
        return this.version == other.version;
    }*/

    @Override
    public String toString() {
        return JSONObject.fromObject(this).toString();
    }

}
