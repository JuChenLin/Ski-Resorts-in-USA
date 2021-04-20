-- Mammoth Mountain
INSERT INTO `ski_resort` (name, website, price_range, annual_snowfall) VALUES ('Mammoth Mountain', 'www.mammothmountain.com', 'HIGH', 400);
INSERT INTO `mountain_stat` (acres, base_elevation, peak_elevation, num_runs, num_lifts, num_terrain_parks, pct_beginner_terrain, pct_intermediate_terrain, pct_advanced_terrain, pct_expert_terrain, ski_resort_id)
       VALUES (3500, 7953, 11053, 150, 25, 10, 15, 48, 24, 13, 1);
INSERT INTO `address` (name, street, city, state, zip_code, ski_resort_id) VALUES ('Main Lodge', '10001 Minaret Road', 'Mammoth Lakes', 'CA', 93546, 1);


-- Heavenly
INSERT INTO `ski_resort` (name, website, price_range, annual_snowfall) VALUES ('Heavenly', 'www.skiheavenly.com', 'HIGH', 360);
INSERT INTO `mountain_stat` (acres, base_elevation, peak_elevation, num_runs, num_lifts, num_terrain_parks, pct_beginner_terrain, pct_intermediate_terrain, pct_advanced_terrain, pct_expert_terrain, ski_resort_id)
       VALUES (4800, 7170, 10067, 97, 28, 3, 8, 62, 25, 5, 2);
INSERT INTO `address` (name, street, city, state, zip_code, ski_resort_id) VALUES ('California Lodge', '3860 Saddle Road', 'South Lake Tahoe', 'CA', 96150, 2);
INSERT INTO `address` (name, street, city, state, zip_code, ski_resort_id) VALUES ('Stagecoach Lodge', '375 Quaking Aspen Lane', 'Stateline', 'NV', 89449, 2);
INSERT INTO `address` (name, street, city, state, zip_code, ski_resort_id) VALUES ('Boulder Lodge', '140 S. Benjamin Drive', 'Stateline', 'NV', 89449, 2);


-- Sugar Bowl
INSERT INTO `ski_resort` (name, website, price_range, annual_snowfall) VALUES ('Sugar Bowl', 'www.sugarbowl.com', 'MEDIUM', 500);
INSERT INTO `mountain_stat` (acres, base_elevation, peak_elevation, num_runs, num_lifts, num_terrain_parks, pct_beginner_terrain, pct_intermediate_terrain, pct_advanced_terrain, pct_expert_terrain, ski_resort_id)
       VALUES (1650, 6883, 8383, 105, 12, 3, 15, 42, 30, 13, 3);
INSERT INTO `address` (street, city, state, zip_code, ski_resort_id) VALUES ('629 Sugar Bowl Rd', 'Norden', 'CA', 95724, 3);


