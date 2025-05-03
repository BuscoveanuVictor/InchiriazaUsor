# Construiește și push-ui imaginea
docker build -t gcr.io/inchiriazausor/inchiriaza-app:prod .
docker push gcr.io/inchiriazausor/inchiriaza-app:prod

kubectl apply -f k8s/deployment.yaml

# kubectl rollout restart deployment inchiriaza-app

# # Așteaptă să se termine rollout-ul
# kubectl rollout status deployment inchiriaza-app

# Afișează logurile
# kubectl logs -l app=inchiriaza-app --tail=50 