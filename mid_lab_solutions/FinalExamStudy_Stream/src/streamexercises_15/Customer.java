package streamexercises_15;

import java.util.Objects;

public class Customer {
	private Long id;
	private String name;
	private Integer tier;
	public Customer(Long id, String name, Integer tier) {
		super();
		this.id = id;
		this.name = name;
		this.tier = tier;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTier() {
		return tier;
	}
	public void setTier(Integer tier) {
		this.tier = tier;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name, tier);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(tier, other.tier);
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", tier=" + tier + "]";
	}
	
	
	
}
