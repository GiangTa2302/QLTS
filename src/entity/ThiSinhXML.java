package entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "thisinh")
@XmlAccessorType(XmlAccessType.FIELD)
public class ThiSinhXML {
	private List<ThiSinh> thiSinh;

	public List<ThiSinh> getThiSinh() {
		return thiSinh;
	}

	public void setThiSinh(List<ThiSinh> thiSinh) {
		this.thiSinh = thiSinh;
	}
}
