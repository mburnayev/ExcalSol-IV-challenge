sudo apt update
sudo apt-get install nodejs npm nginx unzip
sudo chown -R $USER:$USER /var/www
# here you would scp the Angular production build over from your local machine into /var/www/html using a command like
# scp -i <path_to_ec2_pemfile>/frontend_key.pem <path_to_zipped_build>/frontend.zip ubuntu@ec2-54-226-141-7.compute-1.amazonaws.com:/var/www/html/
unzip frontend.zip
cd /etc/nginx/sites-available/
sudo chmod 666 default
vim default # here you update your nginx configuration to read from your project root in /var/www/html/<frontend_build_path>
sudo service nginx restart
# can also do `sudo service nginx status` to track when nginx finishes restarting so you can see your frontend app in the browser
