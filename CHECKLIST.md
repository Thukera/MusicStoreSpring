# ✅ Pre-Push Checklist

Before pushing to GitHub, verify these items:

## 📋 Files Created/Modified

### ✅ New Files Created
- [ ] `Dockerfile` - Multi-stage Docker build configuration
- [ ] `.dockerignore` - Docker build optimization
- [ ] `README.md` - Complete project documentation
- [ ] `DEPLOYMENT_FIX.md` - Fix documentation
- [ ] `test-deployment.sh` - Local testing script
- [ ] `CHECKLIST.md` - This file

### ✅ Files Modified
- [ ] `.github/workflows/deploy.yml` - Fixed directory navigation
- [ ] `musicStore/src/main/resources/application.properties` - Added server port
- [ ] `musicStore/src/main/resources/schema.sql` - H2 database schema
- [ ] `musicStore/src/main/resources/data.sql` - Initial data
- [ ] `musicStore/pom.xml` - Changed MySQL to H2

## 🧪 Local Testing (Optional but Recommended)

### Quick Test
```bash
# Test Maven build
cd musicStore
./mvnw clean package -DskipTests
cd ..

# Test Docker build
docker build -t music-store:test .
```

### Full Test (using test script)
```bash
chmod +x test-deployment.sh
./test-deployment.sh
```

## 🚀 Ready to Deploy?

### 1. Review Changes
```bash
git status
git diff
```

### 2. Stage Changes
```bash
git add .
```

### 3. Commit
```bash
git commit -m "Fix: Deployment workflow and database migration to H2

- Fixed GitHub Actions deployment workflow (mvnw path issue)
- Created Dockerfile with multi-stage build
- Migrated database from MySQL to H2
- Added automatic SQL script initialization
- Updated application.properties with port configuration
- Added .dockerignore for build optimization
- Created comprehensive documentation"
```

### 4. Push
```bash
git push origin master
```

## 🔍 Monitor Deployment

After pushing, monitor the GitHub Actions workflow:

1. Go to: `https://github.com/[your-username]/MusicStoreSpring/actions`
2. Watch the "🚀 Deploy Backend to Orange Pi" workflow
3. Expected stages:
   - ✅ Checkout Code
   - ✅ Deploy Backend
     - Build JAR
     - Build Docker image
     - Deploy container
     - Verify deployment

## ✅ Expected Results

### GitHub Actions Output
```
================================================
🚀 Starting Deployment
================================================
📂 Project structure:
[files listed]
🏗️  Building JAR...
[maven build output]
=== FILES AFTER BUILD ===
[JAR file listed]
🐳 Building Docker image...
[docker build output]
🛑 Stopping old container...
▶️  Starting new container...
✅ Container is running!
[container logs]
================================================
✅ Backend Deployment Complete!
🌐 API: https://musicstore.hardman.app.br
================================================
```

### Verification Steps
1. Visit: `https://musicstore.hardman.app.br`
2. Application should load
3. Products should be visible
4. Database should be initialized with sample data

## 🐛 Troubleshooting

### If deployment fails:

1. **Check workflow logs** in GitHub Actions
2. **Common issues:**
   - Docker not running on self-hosted runner
   - Port 7090 already in use
   - Insufficient memory for Maven build
   - Docker image build failures

3. **Debug on server:**
```bash
# SSH to Orange Pi
ssh user@orangepi

# Check Docker
docker ps -a
docker logs music-store

# Check disk space
df -h

# Check memory
free -h
```

## 📊 Key Changes Summary

| Component | Before | After |
|-----------|--------|-------|
| Database | MySQL | H2 (in-memory) |
| Maven Path | Root | musicStore/ |
| Dockerfile | ❌ Missing | ✅ Multi-stage |
| Port Config | ❌ Default | ✅ 7090 |
| Documentation | ❌ Missing | ✅ Complete |
| SQL Scripts | ❌ RTF only | ✅ schema.sql + data.sql |

## 🎯 Success Criteria

- [ ] GitHub Actions workflow completes successfully
- [ ] Docker container starts and runs
- [ ] Application accessible at https://musicstore.hardman.app.br
- [ ] Database initialized with 10 products
- [ ] H2 console accessible (if enabled in production)
- [ ] No errors in container logs

## 📞 Need Help?

If issues persist:
1. Review `DEPLOYMENT_FIX.md` for detailed fix explanation
2. Check `README.md` for complete setup instructions
3. Review GitHub Actions logs for specific errors
4. Test locally first using `test-deployment.sh`

---

**Good luck with your deployment! 🚀**

