-- Drop stores table if it exists to avoid conflicts
DROP TABLE IF EXISTS stores;

-- Create stores table
CREATE TABLE stores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    localities VARCHAR(500) NOT NULL
);

-- Insert default data for three stores
INSERT INTO stores (name, phone_number, localities) VALUES ('FreshMart Downtown', '012-345-6789', 'City Center,Downtown,Main Street');
INSERT INTO stores (name, phone_number, localities) VALUES ('FreshMart Suburb', '013-456-7890', 'Green Valley,Suburbia,Oak Lane');
INSERT INTO stores (name, phone_number, localities) VALUES ('FreshMart Uptown', '014-567-8901', 'Uptown,Highland,River Road');

