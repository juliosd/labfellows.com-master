build:
	boot build

deploy:
	aws s3 sync target/ s3://labfellows.com --region us-west-2 
