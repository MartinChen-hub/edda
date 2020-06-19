#!/usr/bin/env bash

echo 'deploy start'
kubectl apply -f ./jenkins/deploy.yaml
echo 'deploy successfully'

