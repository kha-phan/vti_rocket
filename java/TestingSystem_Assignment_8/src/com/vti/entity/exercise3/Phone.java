package com.vti.entity.exercise3;

public class Phone<K, V> extends MyMap<K, V> {

	public Phone(K key, V value) {
		super(key, value);
	}

	public V getPhoneNumber() {
		return super.getValue();
	}

}
