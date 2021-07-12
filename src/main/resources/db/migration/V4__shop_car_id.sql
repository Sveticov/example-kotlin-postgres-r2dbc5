CREATE TABLE shop_car(
                         id SERIAL PRIMARY KEY,
                         name TEXT NOT NULL ,
                         address TEXT NOT NULL,
                         phone TEXT NOT NULL,
                         id_car integer references car(id) on delete cascade
);