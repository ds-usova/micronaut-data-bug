# PowerShell script to run tests with proper Docker context
# This script ensures Docker is set to the correct context before running tests

# Unset DOCKER_HOST if it's set
if ($env:DOCKER_HOST) {
    Remove-Item env:DOCKER_HOST -ErrorAction SilentlyContinue
    Write-Host "Unset DOCKER_HOST environment variable"
}

# Switch to desktop-linux context
Write-Host "Switching to desktop-linux Docker context..."
docker context use desktop-linux

# Run Maven tests
Write-Host "Running tests..."
./mvnw.bat clean test -Dtest=BookRepositoryTest

