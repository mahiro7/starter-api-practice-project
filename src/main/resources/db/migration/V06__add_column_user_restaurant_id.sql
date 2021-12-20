ALTER TABLE user ADD COLUMN restaurant_id BIGINT REFERENCES tb_restaurant(id);

