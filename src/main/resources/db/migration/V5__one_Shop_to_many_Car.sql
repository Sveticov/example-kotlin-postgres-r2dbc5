CREATE TABLE shop_car(
                         id SERIAL PRIMARY KEY,
                         name TEXT NOT NULL ,
                         address TEXT NOT NULL,
                         phone TEXT NOT NULL
);

CREATE TABLE car(
                    id SERIAL PRIMARY KEY,
                    name TEXT NOT NULL,
                    series TEXT NOT NULL,
                    age INT NOT NULL,
                    id_shop integer references shop_car(id) on delete cascade
);